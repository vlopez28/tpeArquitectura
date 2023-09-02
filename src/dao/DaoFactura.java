package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import entities.Factura;
import entities.Producto;
import factory.MysqlDAOFactory;
import interfaces.DAO;

public class DaoFactura implements DAO<Factura>{
	private Connection conn;
	public DaoFactura(Connection conn){
		this.conn = conn;
	}
	
	
	@Override
	public void insert(Factura f) throws SQLException {
		if(f.getidCliente() == null || f.getIdFactura() == null) {
				throw new SQLException ("Debe ingresar una factura valida, con todos sus atributos");
		}
		MysqlDAOFactory.getInstance().connect();
		int idFactura = f.getIdFactura();
		int idCliente = f.getidCliente();
		String insert = "INSERT INTO factura (idFactura, idCliente) VALUES( ?, ?)  ";
		PreparedStatement ps = this.conn.prepareStatement(insert);
		ps.setInt(1, idFactura);
		ps.setInt(2, idCliente);
		ps.executeUpdate();
		ps.close();
		MysqlDAOFactory.getInstance().close();
	}
	
	public Producto productoConMasRecaudacion() {
		Producto producto = new Producto(null, null, null);
		try {
			Connection conectar = MysqlDAOFactory.getInstance().connect();
		
			String select =
"SELECT p.idProducto, p.nombre, p.valor, SUM(fp.cantidad * p.valor) AS total_recaudado FROM producto p JOIN factura_producto fp ON p.idProducto = fp.idProducto GROUP BY p.idProducto, p.valor ORDER BY total_recaudado DESC LIMIT 1";
				PreparedStatement ps = conectar.prepareStatement(select);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Integer id = rs.getInt(1);
					String nombre = rs.getString(2);
					Float valor = rs.getFloat(3);
					producto.setIdProducto(id);
					producto.setNombre(nombre);
					producto.setValor(valor);
				}
				MysqlDAOFactory.getInstance().close();
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}

	@Override
	public Factura get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Factura t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Factura t, String[] params) {
		// TODO Auto-generated method stub
	}


	@Override
	public void delete(Factura t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
