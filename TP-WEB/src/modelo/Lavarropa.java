package modelo;

public class Lavarropa extends Electrodomestico {

	double carga;

	static final double CARGA = 5;

	public Lavarropa() {

		super();
		this.carga = CARGA;

	}

	public Lavarropa(double precio, double peso1, String color1, char consumo,
			double carga1) {
		super(precio, peso1, color1, consumo);
		this.carga = carga1;

	}

	public Lavarropa(double precio, double peso1) {
		super(precio, peso1);
		this.carga = CARGA;

	}

	public double getCarga() {
		return carga;
	}

	public double precioFinal() {

		double precioFinal = 0;

		precioFinal = super.precioFinal();

		if (peso > 30) {
			precioFinal = precioFinal + 50;
		}

		return precioFinal;

	}

	public void setCarga(double carga) {
		this.carga = carga;
	}
	
	public String toString() {
		return "Lavarropa [idElectrodomestico=" + idElectrodomestico + ", peso=" + peso
				+ ", precioBase=" + precioBase + ",color=" + color.color + ", consumo="
				+ consumoEnergetico.consumoEner + ",carga="+ carga +"]";
	}

}
