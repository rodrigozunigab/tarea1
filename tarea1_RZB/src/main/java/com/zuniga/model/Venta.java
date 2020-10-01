package com.zuniga.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "venta")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;
	
	@ManyToOne
	@JoinColumn(name = "id_vendedor", nullable = false, foreignKey = @ForeignKey(name="FK_vendedor_venta"))
	private Vendedor vendedor;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name="FK_cliente_venta"))
	private Cliente cliente;	
	
	@Column(name = "costo",nullable = false)
	private Integer costo;
	
	private LocalDateTime fechaVenta;
	
	/*@OneToMany(mappedBy = "venta", cascade = {CascadeType.ALL}, orphanRemoval = true)
	private List<CompraProducto> detalleCompraProducto;*/
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "compra_producto",
        joinColumns = @JoinColumn(name = "id_venta", referencedColumnName = "idVenta"),
        inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "idProducto"))
    private List<Producto> detalleCompraProducto;
    
	
	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	/*public List<CompraProducto> getDetalleCompraProducto() {
		return detalleCompraProducto;
	}
	public void setDetalleCompraProducto(List<CompraProducto> detalleCompraProducto) {
		this.detalleCompraProducto = detalleCompraProducto;
	}*/
	
	public List<Producto> getDetalleCompraProducto() {
		return detalleCompraProducto;
	}
	public void setDetalleCompraProducto(List<Producto> detalleCompraProducto) {
		this.detalleCompraProducto = detalleCompraProducto;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVenta == null) ? 0 : idVenta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		if (idVenta == null) {
			if (other.idVenta != null)
				return false;
		} else if (!idVenta.equals(other.idVenta))
			return false;
		return true;
	}

	
	
	
}
