package br.com.wendel.screenmatch;

import br.com.wendel.screenmatch.model.DadosSerie;
import br.com.wendel.screenmatch.service.ConsumoAPI;
import br.com.wendel.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI = new ConsumoAPI();
		ConverteDados converteDados = new ConverteDados();

		var retornoAPI = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		var dadosSerieJSON = converteDados.obterDados(retornoAPI, DadosSerie.class);

		System.out.println(dadosSerieJSON);
	}
}
