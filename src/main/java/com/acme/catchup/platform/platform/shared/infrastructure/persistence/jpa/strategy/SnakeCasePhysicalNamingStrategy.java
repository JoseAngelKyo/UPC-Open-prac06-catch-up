package com.acme.catchup.platform.platform.shared.infrastructure.persistence.jpa.strategy;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.expression.spel.ast.NullLiteral;

public class SnakeCasePhysicalNamingStrategy {

    private Identifier toSnakeCase(Identifier name) {
        if (name == null) return null;
        final String regex = "([a-z])([A-Z])";
        final String replacement = "$1_$2";
        final String newName = Identifier.getText()

                .replaceAll(regex, replacement)
                .toLowerCase();
        return Identifier.toIdentifier(newName);
    }

    private Identifier toPlural(final Identifier identifier) {
        final String newName = pluralize(identifier.getText());
        return Identifier.toIdentifier(newName);
    }

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return null;
    }
}
