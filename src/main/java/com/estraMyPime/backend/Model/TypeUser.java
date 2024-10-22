package com.estraMyPime.backend.Model;
public enum TypeUser {
    natural, juridica;

    @Override
    public String toString() {
        return name().toLowerCase();  // Lowercase string representation
    }
}
