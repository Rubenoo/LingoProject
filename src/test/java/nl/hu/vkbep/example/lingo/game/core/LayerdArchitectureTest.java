package nl.hu.vkbep.example.lingo.game.core;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "nl.hu.vkbep.example.lingo.game.core", importOptions = { ImportOption.DoNotIncludeTests.class })
public class LayerdArchitectureTest {

    @ArchTest
    static final ArchRule dependencyRule = layeredArchitecture()

            .layer("Domain").definedBy("nl.hu.vkbep.example.lingo.game.core.domain..")
            .layer("Persistence").definedBy("nl.hu.vkbep.example.lingo.game.core.persistence..")
            .layer("Application").definedBy("nl.hu.vkbep.example.lingo.game.core.application..")
            .layer("Presentation").definedBy("nl.hu.vkbep.example.lingo.game.core.presentation..")

            .whereLayer("Presentation").mayNotBeAccessedByAnyLayer()
            .whereLayer("Application").mayOnlyBeAccessedByLayers("Presentation")
            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Application")
            .whereLayer("Domain").mayOnlyBeAccessedByLayers("Application");
}
