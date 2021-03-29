package io.kebblar.petstore.api.mapper;

import io.kebblar.petstore.api.model.Factura;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface FacturaMapper {

    static final String FACTURA_DATOS = "id, fecha, cliente_rfc, id_producto, precio, iva";
    @Results(id = "factMap", value = {
            @Result(property = "id",  column = "id"),
            @Result(property = "fecha",        column = "fecha"),
            @Result(property = "clienteRfc",    column = "cliente_rfc"),
            @Result(property = "idProducto",     column = "id_producto"),
            @Result(property = "precio",      column = "precio"),
            @Result(property = "iva",      column = "iva")
    })
    @Select("SELECT " + FACTURA_DATOS + " FROM factura")
    List<Factura> getAll() throws SQLException;

    @Insert("INSERT into factura("+FACTURA_DATOS+" FROM factura) VALUES (#{id}, #{fecha}, #{clienteRfc}, #{idProducto}, #{precio}, #{iva}")
    int insert(Factura factura) throws SQLException;

    @Update("UPDATE factura SET fecha=#{fecha}, cliente_rfc=#{clienteRfc}, id_producto=#{idProducto}, precio=#{precio}, iva=#{iva} WHERE id=#{id}")
    int update(Factura factura) throws SQLException;

    @ResultMap("factMap")
    @Select("SELECT id,fecha, cliente_rfc, id_producto, precio, iva FROM factura WHERE id=#{id}")
    Factura getById(int id) throws SQLException;

    @Delete("DELETE FROM factura WHERE id=#{id}")
    int delete(int id) throws SQLException;
}
