package br.edu.ifpb.pdist.graphqlexample.model;


import java.math.BigDecimal;

public record ProductInput(String name, BigDecimal price, Long categoryId) {}
