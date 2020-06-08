package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.CadastrarNovaContaNoFacebookPage;

public class CadastroFacebookTest {

	private static CadastrarNovaContaNoFacebookPage facebook;
	private static WebDriver driver;
	
	private String nome = "Hulk";
	private String sobrenome = "Thor";
	private String email = "hulk.thor@gmail.com";
	private String senha = "Test1234";
	private String nascimento = "3/7/1995";
	private String genero = "Masculino";
	
	@Before
	public void preCondicao() {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		facebook = new CadastrarNovaContaNoFacebookPage(driver);
		
	}
	
		
	@Test
	public void cadastroFacebookComSucesso() throws InterruptedException {
		
		
		facebook.criarConta(nome, sobrenome, email, senha, nascimento, genero);
	
		
	}

}
