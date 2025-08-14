public class RegimenHorario {
    private int horaIngreso;
    private int minutoIngreso;
    private int horaEgreso;
    private int minutoEgreso;

    private Empleado empleado;

    public RegimenHorario(int horaIngreso, int minutoIngreso, int horaEgreso, int minutoEgreso, Empleado empleado) {
        this.horaIngreso = horaIngreso;
        this.minutoIngreso = minutoIngreso;
        this.horaEgreso = horaEgreso;
        this.minutoEgreso = minutoEgreso;
        this.empleado = empleado;
    }

    public int getHoraIngreso() { return horaIngreso; }
    public int getMinutoIngreso() { return minutoIngreso; }
    public int getHoraEgreso() { return horaEgreso; }
    public int getMinutoEgreso() { return minutoEgreso; }
}
