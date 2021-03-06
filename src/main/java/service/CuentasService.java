package service;

import java.util.List;

import model.Cuenta;

public interface CuentasService {
	public boolean	newCuenta(Cuenta cuenta);
	public List<Cuenta> allCuentas();
	public Cuenta findCuenta(int numeroCuenta);
	public void deleteCuenta(int numeroCuenta);
	public void updateCuenta(int numeroCuenta, double saldo);

}
