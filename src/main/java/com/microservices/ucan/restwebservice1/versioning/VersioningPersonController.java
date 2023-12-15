package com.microservices.ucan.restwebservice1.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	// url versioning

	@GetMapping("/v1/person")
	public Person getPerson() {
		return new Person("John Carter", 36, "Carpenter");
	}
	
	@GetMapping("/v2/person")
	public Personv2 getPersonV2() {
		return new Personv2(new Name("John", "Carter"), 36, "Carpenter");
	}
	
	//versioning using path param
	
	@GetMapping(path="/person", params="version=1")
	public Person getPersonWithParamV1() {
		return new Person("John Carter", 36, "Carpenter");
	}
	
	@GetMapping(path="/person", params="version=2")
	public Personv2  getPersonWithParamV2() {
		return new Personv2(new Name("John", "Carter"), 36, "Carpenter");
	}
	
	//versioning using (custom ) header X-API-VERSION
	
	@GetMapping(path="/person", headers="X-API-VERSION=1")
	public Person getPersonV1WithXapi() {
		return new Person("John Carter", 36, "Carpenter");
	}
	
	@GetMapping(path="/person", headers="X-API-VERSION=2")
	public Personv2  getPersonV2WithXapi() {
		return new Personv2(new Name("John", "Carter"), 36, "Carpenter");
	}
	
	//versioning using media type (accept ) versioning ( content negotiation )
	
	@GetMapping(path="/person", produces = "application/vnd.company.app-v1+json")
	public Person getPersonV1WithAcceptHeader() {
		return new Person("John Carter", 36, "Carpenter");
	}
	
	@GetMapping(path="/person", produces = "application/vnd.company.app-v2+json")
	public Personv2  getPersonV2WithAcceptHeader() {
		return new Personv2(new Name("John", "Carter"), 36, "Carpenter");
	}
}
