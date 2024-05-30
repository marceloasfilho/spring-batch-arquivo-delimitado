package com.github.marceloasfilho.springbatcharquivodelimitado.step;

import com.github.marceloasfilho.springbatcharquivodelimitado.entity.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class LeituraArquivoDelimitadoStepConfig {
    @Bean
    public Step leituraArquivoLarguraFixaStep(ItemReader<Cliente> leituraArquivoDelimitadoReader,
                                              ItemWriter<Cliente> leituraArquivoDelimitadoWriter,
                                              JobRepository jobRepository,
                                              PlatformTransactionManager transactionManager) {
        return new StepBuilder("leituraArquivoLarguraDelimitadaStep", jobRepository)
                .<Cliente, Cliente>chunk(1, transactionManager)
                .reader(leituraArquivoDelimitadoReader)
                .writer(leituraArquivoDelimitadoWriter)
                .build();
    }
}
