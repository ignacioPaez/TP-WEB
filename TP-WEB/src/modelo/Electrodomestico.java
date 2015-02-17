package modelo;

public class Electrodomestico {

	static final double PRECIOBASE = 100, PESO = 5;
	static final String COLOR = "Blanco";
	static final char CONSUMOENERGETICO = 'F';

	double precioBase, peso;
	Color color;
	ConsumoEnergetico consumoEnergetico;
	int idElectrodomestico;

	public Electrodomestico() {

		color = new Color();
		consumoEnergetico = new ConsumoEnergetico();

		this.precioBase = PRECIOBASE;
		this.peso = PESO;
		this.color.setColor(COLOR);
		this.consumoEnergetico.setConsumoEner(CONSUMOENERGETICO);

	}

	public Color getColor() {
		return color;
	}

	public ConsumoEnergetico getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public Electrodomestico(double precio, double peso1) {

		color = new Color();
		consumoEnergetico = new ConsumoEnergetico();

		this.precioBase = precio;
		this.peso = peso1;
		this.color.setColor(COLOR);
		this.consumoEnergetico.setConsumoEner(CONSUMOENERGETICO);

	}

	public Electrodomestico(double precio, double peso1, String color1,
			char consumo) {

		color = new Color();
		consumoEnergetico = new ConsumoEnergetico();

		this.precioBase = precio;
		this.peso = peso1;
		this.color.setColor(color1);
		this.consumoEnergetico.setConsumoEner(consumo);

	}

	public double getPrecioBase() {
		return precioBase;
	}

	public double getPeso() {
		return peso;
	}

	private void comprobarConsumoEnergetico() {

		if (consumoEnergetico.getConsumoEner() >= 'A'
				&& consumoEnergetico.getConsumoEner() <= 'F') {

		}

		else {
			consumoEnergetico.setConsumoEner(CONSUMOENERGETICO);

		}

	}

	private void comprobarColor() {
		switch (color.getColor()) {
		case "Blanco":

			break;
		case "Negro":

			break;
		case "Azul":
			break;
		case "Gris":
			break;

		default:
			color.setColor(COLOR);
			break;
		}

	}

	public double precioFinal() {

		double precioFinal = 0;

		precioFinal = precioBase + consumoEnergetico.getPrecio();

		if (peso >= 0 && peso <= 19) {

			precioFinal = precioFinal + 10;

		} else if (peso >= 20 && peso <= 49) {
			precioFinal = precioFinal + 50;

		} else if (peso >= 50 && peso <= 79) {
			precioFinal = precioFinal + 80;

		} else if (peso >= 80) {
			precioFinal = precioFinal + 100;

		}

		return precioFinal;

	}

	public int getIdElectrodomestico() {
		return idElectrodomestico;
	}

	public void setIdElectrodomestico(int idElectrodomestico) {
		this.idElectrodomestico = idElectrodomestico;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setConsumoEnergetico(ConsumoEnergetico consumoEnergetico) {
		this.consumoEnergetico = consumoEnergetico;
	}

	
}



