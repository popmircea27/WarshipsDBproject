package Controllers;

public class Clase {
    private String claseCls;
    private String tipCls;
    private String taraCls;
    private String diamTunCls;
    private String nrArmeClss;
    private String deplasamentCls;

    public Clase(String claseCls, String tipCls, String taraCls, String diamTunCls, String deplasamentCls,String nrArmeClss) {
        this.claseCls = claseCls;
        this.tipCls = tipCls;
        this.taraCls = taraCls;
        this.diamTunCls = diamTunCls;
        this.deplasamentCls = deplasamentCls;
        this.nrArmeClss=nrArmeClss;
    }

    public String getClaseCls() {
        return claseCls;
    }

    public String getTipCls() {
        return tipCls;
    }

    public String getTaraCls() {
        return taraCls;
    }

    public String getDiamTunCls() {
        return diamTunCls;
    }

    public String getDeplasamentCls() {
        return deplasamentCls;
    }

    public String getNrArmeClss() {
        return nrArmeClss;
    }
}
