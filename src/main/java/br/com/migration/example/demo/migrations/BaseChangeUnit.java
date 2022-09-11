package br.com.migration.example.demo.migrations;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseChangeUnit {

    public abstract void changeUnit();

    public abstract void rollback();

}
