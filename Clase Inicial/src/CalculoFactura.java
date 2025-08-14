import java.util.Scanner;

public class CalculoFactura {
    static String[][] articulos = {
            {"100", "Azucar", "20", "U"},
            {"101", "Leche", "30", "U"},
            {"102", "Aceite", "50", "U"},
            {"103", "Sal", "45", "U"},
            {"104", "Fideos", "15", "U"},
            {"105", "Arroz", "28", "U"},
            {"106", "Galletas", "26", "U"},
            {"107", "Carne Molida", "220", "Kg"},
            {"108", "Shampoo", "42", "U"},
            {"109", "Queso Mantecoso", "178", "Kg"},
            {"110", "Jamon Cocido", "320", "Kg"},
            {"111", "Naranjas", "80", "Kg"}
    };
    public void iniciarFactura() {
        Scanner sc = new Scanner(System.in);
        Factura factura = new Factura();

        // a) Datos de cabecera de factura
        System.out.print("Ingrese la fecha: ");
        factura.setFecha(sc.nextLine());

        System.out.print("Ingrese el número de factura: ");
        factura.setNroFactura(Long.parseLong(sc.nextLine()));

        System.out.print("Ingrese la razón social (cliente): ");
        factura.setRazonSocial(sc.nextLine());

        System.out.print("Ingrese el CUIT del cliente: ");
        factura.setCuitCliente(Long.parseLong(sc.nextLine()));

        String tipoPago;
        do {
            System.out.print("Ingrese el tipo de pago (C - TC - TD): ");
            tipoPago = sc.nextLine().toUpperCase();
        } while (!(tipoPago.equals("C") || tipoPago.equals("TC") || tipoPago.equals("TD")));
        factura.setTipoPago(tipoPago);

        // b) Cantidad de artículos
        int cantArticulos;
        do {
            System.out.print("Ingrese la cantidad de artículos a facturar: ");
            cantArticulos = Integer.parseInt(sc.nextLine());
        } while (cantArticulos <= 0);

        // c) Dimensionar itemsFactura
        String[][] items = new String[cantArticulos][5];
        factura.setItemsFactura(items);

        // d) Carga de artículos
        double totalItems = 0;
        for (int i = 0; i < cantArticulos; i++) {
            System.out.println("\nArtículo " + (i + 1) + ":");
            String[] articulo = null;
            while (articulo == null) {
                System.out.print("Ingrese el código del artículo: ");
                String cod = sc.nextLine();
                articulo = buscarArticulo(cod);
                if (articulo == null) {
                    System.out.println("El código ingresado es incorrecto.");
                } else {
                    // Asignar código, denominación y precio
                    items[i][0] = articulo[0]; // código
                    items[i][1] = articulo[1]; // denominación
                    items[i][2] = articulo[2]; // precio unitario

                    // Pedir cantidad
                    double cantidad = 0;
                    boolean valida = false;
                    while (!valida) {
                        System.out.print("Ingrese la cantidad a facturar (" + articulo[3] + "): ");
                        String cantStr = sc.nextLine();
                        try {
                            if (articulo[3].equals("U")) {
                                cantidad = Integer.parseInt(cantStr);
                                valida = true;
                            } else if (articulo[3].equals("Kg")) {
                                cantidad = Double.parseDouble(cantStr);
                                valida = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Cantidad inválida, intente de nuevo.");
                        }
                    }

                    items[i][3] = String.valueOf(cantidad);

                    // Subtotal
                    double precio = Double.parseDouble(articulo[2]);
                    double subtotal = precio * cantidad;
                    items[i][4] = String.valueOf(subtotal);

                    totalItems += subtotal;
                }
            }
        }

        // e) Calcular monto total de ítems
        factura.setMontoTotalItems(totalItems);

        // f) Calcular recargo
        double recargo = 0;
        if (factura.getTipoPago().equals("TD")) {
            recargo = totalItems * 0.05;
        } else if (factura.getTipoPago().equals("TC")) {
            recargo = totalItems * 0.10;
        }
        factura.setRecargo(recargo);

        // g) Calcular monto final
        factura.setMontoFinal(totalItems + recargo);

        // h) Mostrar ticket
        System.out.println("\n==============================");
        System.out.println("El ticket a pagar es: $" + factura.getMontoFinal());
        System.out.println("==============================");
    }
    public static String[] buscarArticulo(String cod) {
        for (String[] art : articulos) {
            if (art[0].equals(cod)) {
                return art;
            }
        }
        return null;
    }
}



