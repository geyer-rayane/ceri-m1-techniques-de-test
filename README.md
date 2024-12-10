# :star: **UCE Génie Logiciel Avancé : Techniques de tests** :star:

## :id: Informations

**Nom :** Rayane GEYER  
**Groupe :** Groupe ILSEN ALT

---

## :bookmark_tabs: Badges

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/geyer-rayane/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/geyer-rayane/ceri-m1-techniques-de-test/tree/master)
[![codecov](https://codecov.io/github/geyer-rayane/ceri-m1-techniques-de-test/graph/badge.svg?token=SMJIHS7Y8H)](https://codecov.io/github/geyer-rayane/ceri-m1-techniques-de-test)
[![Checkstyle Status](https://img.shields.io/badge/Checkstyle-CheckStyle-blue)](http://lien-de-votre-choix.com)

# Documentation du Projet : :book: 

## Difficultés Initiales

La prise en main des classes m'a pris du temps. J'ai plutôt l'habitude de développer from scratch avec le TDD plutôt qu'avec des interfaces "forçant" la définition générale des méthodes.

## Choix de développement après l'implémentation des classes

### 1. Création de Nouvelles Classes de Tests

J'ai fais le choix de créer des classes de tests spécifiques pour les implémentations plutôt que de modifier les classes de tests abstraites (utilisant des mocks). Ce choix m'a permis de faciliter la transition entre les tests type Mock vers des tests "réels". Il aurait pu être plus judificieux d'ajouter d'une couche d'abstraction au niveau des mocks afin de faciliter encore plus ce passag, comme nous l'avons évoquer à l'oral aujourdhui (15/11). 

### 2. Choix arbitraires

J'ai fais le choix de calculer l'individual value du type Pokemon en prenant la moyenne entre ses 3 statistiques : attaque défense et endurance. Le tout divisé par 45. Formule trouvée sur un site fan de Pokemon. 

### 2. Utilisation Maximale des Implémentations dans les Tests

J'ai essayé d'utiliser au plus tôt les implémentations concrètes dans les tests. Peut être aurait il été plus judicieux de faire ça de façon incrémentale afin de ne pas découvrir des problèmes liés entre de trop nombreuses classes.

### 3. Noms des Classes : Problèmes de Nommage

Certains noms de classes ont été source de confusion, notamment `IPokemonMetadata` et `IPokemonMetaDataProvider`. La similitude a prêter à confusion, notamment au niveau du "d" et du "D" (nombreuses erreurs de symbol :( )).

### 4. Tests Courts et Modulaires

Aussi, j'ai fais le choix de structurer les tests de manière courte et modulaire plutôt que de faire des tests utilisant énormément d'assertequals et de comparatifs..

### 5. Gestion des Problèmes dans les Classes

J'ai gérer directement dans certaines classes les problèmes liés aux valeurs maximales, minimales, ou autres contraintes (ex : `PokemonTrainerFactory`).

## :eyes: Description du projet

<details>
  <summary>Click pour voir plus...</summary>

  To be continued...

  Ce projet concerne l'apprentissage et l'application des **techniques de tests** dans un environnement **Java**, avec l'intégration de tests automatisés, la couverture de code, et l'analyse de la qualité via des outils comme **CircleCI** et **Codecov**.

</details>

--- 

## :rocket: Technologies utilisées

- :coffee: **Java 11** (OpenJDK)
- :hammer_and_wrench: **Maven** pour la gestion de projet
- :bar_chart: **JaCoCo** pour la couverture de code
- :white_check_mark: **JUnit** pour les tests unitaires
- :package: **CircleCI** pour l'intégration continue
- :ballot_box_with_check: **Codecov** pour la gestion de la couverture de test

---

## :muscle: Objectifs

<details>
  <summary>Voir les objectifs du projet</summary>

  - :pencil: Mettre en place une pipeline CI/CD avec CircleCI.
  - :test_tube: Intégrer des tests unitaires et générer un rapport de couverture avec JaCoCo.
  - :bar_chart: Visualiser la couverture de test sur **Codecov**.
  - :star2: Assurer la qualité du code avec des outils d'analyse automatique.

</details>

---

## :wrench: Instructions pour les développeurs

1. Clonez le repository :

```bash
git clone https://github.com/geyer-rayane/ceri-m1-techniques-de-test.git






