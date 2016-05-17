/**
 * 
 */
package com.ks.rrs.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.ks.rrs.batch.CustomFieldMapper;
import com.ks.rrs.batch.CustomItemProcessor;
import com.ks.rrs.batch.CustomItemWriter;
import com.ks.rrs.jpa.model.Rate;

/**
 * @author Tino097
 *
 */
@Configuration
@EnableBatchProcessing
public class BatchJobsConfig implements ResourceLoaderAware {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;



	private ResourceLoader resourceLoader;

	@Bean
	ItemReader reader(){
		//CustomItemReader reader = new CustomItemReader();
		MultiResourceItemReader filesReader = new MultiResourceItemReader();
		Resource[] resources = new Resource[] { resourceLoader.getResource("file:/rates-*") };
		filesReader.setResources(resources);
		FlatFileItemReader fileReader = new FlatFileItemReader(); 
		DefaultLineMapper lineMapper = new DefaultLineMapper();

		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(null);
		tokenizer.setNames(new String[]{"rawRate"});
		
		 FieldSetMapper fieldSetMapper = new CustomFieldMapper(filesReader.getCurrentResource().getFilename()); 
		  lineMapper.setLineTokenizer(tokenizer); 
		  lineMapper.setFieldSetMapper(fieldSetMapper); 
		   
		  fileReader.setLineMapper(lineMapper); 
		   
		  filesReader.setDelegate(fileReader); 
		  
		return filesReader;
	}

	@Bean
	ItemProcessor<RawRate, Rate> processor() {
		return new CustomItemProcessor();
	}

	@Bean
	ItemWriter writer() {
		return new CustomItemWriter();
	}

	@Bean
	public Job importUserJob() {
		return jobBuilderFactory.get("rateJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<RawRate, Rate> chunk(10).reader(reader()).processor(processor())
				.writer(writer()).build();
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		// TODO Auto-generated method stub
		this.resourceLoader = resourceLoader;
	}

}
