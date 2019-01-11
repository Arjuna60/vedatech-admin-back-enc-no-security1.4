package com.vedatech.admin.bank;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.admin.BaseEntity;
import com.vedatech.admin.accounting.AccountPolicy;
import com.vedatech.admin.accounting.SubAccount;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bank_transactions")
public class BankTransaction extends BaseEntity {


    @Column(name = "fecha_operacion")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaOperacion;

    @Column(name = "fecha")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "codigo_transfer")
    private String codigoTransf;

    @Column
    private String sucursal;

    @Column
    private Double deposito;

    @Column
    private Double retiro;

    @Column
    private Double saldo;

    @Column
    private String movimiento;

    @Column(name = "descrip_detalle")
    private String descripcionDetalle;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="bank_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Bank bank;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_policy_id")
    private List<AccountPolicy> accountPolicyList;


    @Override
    public String toString() {
        return "BankTransaction{" +
                "fechaOperacion=" + fechaOperacion +
                ", fecha=" + fecha +
                ", referencia='" + referencia + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", codigoTransf='" + codigoTransf + '\'' +
                ", sucursal='" + sucursal + '\'' +
                ", deposito=" + deposito +
                ", retiro=" + retiro +
                ", saldo=" + saldo +
                ", movimiento='" + movimiento + '\'' +
                ", descripcionDetalle='" + descripcionDetalle + '\'' +
                '}';
    }
}

