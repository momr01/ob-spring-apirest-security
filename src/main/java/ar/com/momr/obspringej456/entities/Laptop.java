package ar.com.momr.obspringej456.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laptops")
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String os;
	private Integer ram;
	private Double disc;
	private Integer usbPorts;
	
	public Laptop() {
	}

	public Laptop(Long id, String brand, String os, Integer ram, Double disc, Integer usbPorts) {
		this.id = id;
		this.brand = brand;
		this.os = os;
		this.ram = ram;
		this.disc = disc;
		this.usbPorts = usbPorts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public Double getDisc() {
		return disc;
	}

	public void setDisc(Double disc) {
		this.disc = disc;
	}

	public Integer getUsbPorts() {
		return usbPorts;
	}

	public void setUsbPorts(Integer usbPorts) {
		this.usbPorts = usbPorts;
	}
	
	
	
	
	
	
	

}
