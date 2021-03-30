package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.springframework.stereotype.Repository;

import java.util.List;

import io.kebblar.petstore.api.model.Factura;

@Repository
public interface FacturaMapper {
	
	static final String FACTURA_FIELDS = "id, fecha, cliente_rfc, id_producto, precio, iva";
	
	@Results(id="FacturaResultMap", value = {
			@Result(property = "id",          column = "id"),
			@Result(property = "fecha",       column = "fecha"),
			@Result(property = "clienteRfc",  column = "cliente_rfc"),
			@Result(property = "idProducto",  column = "id_producto"),
			@Result(property = "precio", 	  column = "precio"),
			@Result(property = "iva",         column = "iva")		
	})
	@Select("select "+FACTURA_FIELDS+" iva FROM factura")
	List<Factura> getAll() throws SQLException;

	@Insert("insert into factura(fecha, cliente_rfc, id_producto, precio) values (#{fecha}, #{cliente}")
	int insert(Factura factura) throws SQLException;
	
	@Update("update factura SET id_producto=#(idProducto) WHERE id=#(id)")
	int update(Factura factura) throws SQLException;
	
	@Delete("delete FROM factura where id=#{id}")
	int delete(int id) throws SQLException;
	
	@ResultMap("FacturaResultMap")
	@Select("select "+FACTURA_FIELDS+" FROM factura where id_producto=#{idProd}")
	List<Factura> findByIdProd(int idProd) throws SQLException;
	
	@ResultMap("FacturaResultMap")
	@Select("select "+FACTURA_FIELDS+" FROM factura where id=#{key}")
	Factura findByIdPrimaryKey(int idProd) throws SQLException;
}
