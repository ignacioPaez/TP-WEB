package modelo;

public class Televisor extends Electrodomestico {

	static final double RESOLUCION = 20;
	static final boolean SINTONIZADOR = false;

	double resolucion;
	boolean sintonizador;

	public Televisor() {

		super();
		this.resolucion = RESOLUCION;
		this.sintonizador = SINTONIZADOR;

	}

	public Televisor(double precio, double peso1, String color1, char consumo,
			boolean sintonizador, double resolucion) {

		super(precio, peso1, color1, consumo);
		this.sintonizador = sintonizador;
		this.resolucion = resolucion;

	}

	public Televisor(double precio, double peso1) {

		super(precio, peso1);
		this.resolucion = RESOLUCION;
		this.sintonizador = SINTONIZADOR;

	}

	public double getResolucion() {
		return resolucion;
	}

	public boolean isSintonizador() {
		return sintonizador;
	}

	public double precioFinal() {

		double precioFinal = 0;

		precioFinal = super.precioFinal();

		if (resolucion > 40) {

			precioFinal = precioFinal + (precioFinal * 0.30);
		}

		if (sintonizador == true) {

			precioFinal = precioFinal + 50;
		}

		return precioFinal;

	}

	public void setResolucion(double resolucion) {
		this.resolucion = resolucion;
	}

	public void setSintonizador(boolean sintonizador) {
		this.sintonizador = sintonizador;
	}
	
	public String toString() {
		return "Televisor [idElectrodomestico=" + idElectrodomestico + ", peso=" + peso
				+ ", precioBase=" + precioBase + ",color=" + color.color + ", consumo="
				+ consumoEnergetico.consumoEner + ",resolucion="+ resolucion +",sintonizador=" + sintonizador+ "]";
	}

}
