package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "features" }, plugin = { "pretty", "html:Report1" },
	// name = {"advanced search"}, //se van a ejecutar los scenarios que contengan
	// en el nombre esas palabras
	tags = "@P4", // para elegir los tags que se ejecutaran
	monochrome = true, // es para q el output sea en un poco mas limpio
	dryRun = false, // se usa para ver solamente si hay algun step q no tenga asociada su definicion
	glue = { "steps" }) // en glue se escribe donde estan las steps definitions
public class TestRunner {

}
