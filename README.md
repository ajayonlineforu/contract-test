# contract-test

##Producer

1. Producer of service has to include below dependency and maven plugin.

        <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-contract-verifier</artifactId>
			<scope>test</scope>
		</dependency>
		
		<plugin>
            <groupId>org.springframework.cloud</groupId>
        	<artifactId>spring-cloud-contract-maven-plugin</artifactId>
        	<version>3.0.3</version>
            <extensions>true</extensions>
        	    <configuration>
        		<testFramework>JUNIT5</testFramework>
        		<baseClassForTests>com.example.producer.BaseTestClass</baseClassForTests>
        		</configuration>
        </plugin>
        
2. we need to create contract files defined in groovy inside test/resources/contract folder.

3. Once we run mvn clean install, below thing happens
  - creates java test files inside target.
  - creates stubs jar based on wire mock that can be used at client side.
  - Generated java classes can be used as junit tests.
  
##Consumer

1. we need to include below dependency

            <dependency>
    			<groupId>org.springframework.cloud</groupId>
    			<artifactId>spring-cloud-starter-contract-stub-runner</artifactId>
    			<scope>test</scope>
    		</dependency>
    		
2. we need to configure test class to use stubs jar that was creted by producer. IT Downloads the jar from mvn repo unpack and use this to create wiremock server and stubs.

        .               downloadStub("com.example", "producer", "0.0.1-SNAPSHOT", "stubs")
        			.withPort(8100)
        			.stubsMode(StubRunnerProperties.StubsMode.LOCAL);
    		
  