package com.quizquick.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModule;
    private String nameModule;
    private int moduleStatus;

    public Module () {}

    public Module(String nameModule, int moduleStatus) {
        this.nameModule = nameModule;
        this.moduleStatus = moduleStatus;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public String getNameModule() {
        return nameModule;
    }

    public void setNameModule(String nameModule) {
        this.nameModule = nameModule;
    }

    public int getModuleStatus() {
        return moduleStatus;
    }

    public void setModuleStatus(int moduleStatus) {
        this.moduleStatus = moduleStatus;
    }

    @Override
    public String toString() {
        return "Module{" +
                "idModule=" + idModule +
                ", nameModule='" + nameModule + '\'' +
                ", moduleStatus=" + moduleStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Module)) return false;
        Module module = (Module) o;
        return getIdModule() == module.getIdModule() &&
                getModuleStatus() == module.getModuleStatus() &&
                Objects.equals(getNameModule(), module.getNameModule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdModule(), getNameModule(), getModuleStatus());
    }
}
