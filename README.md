# 🏦 E-BANK – Bank Management System

## 📝 Description du projet

**E-BANK** est une application Java de gestion bancaire développée selon les principes de la **Programmation Orientée Objet (POO)**.

Elle permet de gérer des clients et leurs comptes bancaires, ainsi que d’effectuer les opérations bancaires de base :

* Création de clients
* Création de comptes
* Dépôt
* Retrait
* Consultation de solde
* Suppression de compte

Le système est conçu avec une architecture claire, modulaire et extensible.

---

## 🎯 Objectifs pédagogiques

Ce projet permet de pratiquer :

* ✅ La Programmation Orientée Objet (POO)
* ✅ L’héritage et le polymorphisme
* ✅ Les associations entre classes
* ✅ La gestion des collections (List, Map)
* ✅ La validation des données
* ✅ L’organisation d’un projet Java structuré
* ⭐ Manipulation de fichiers (export Excel – bonus)

---

## 🏗️ Conception – Diagramme de classes

Le diagramme de classes comprend au minimum :

* `Person`
* `Client` (hérite de `Person`)
* `Account`
* `SavingsAccount` (hérite de `Account`) – Bonus
* `Bank`
* `Main`

### Relations principales :

* `Client` hérite de `Person`
* `SavingsAccount` hérite de `Account`
* `Bank` gère une collection de `Client` et `Account`
* Un `Client` peut posséder plusieurs comptes

---

## 🧩 Modèle des classes

### 👤 Person

Représente une personne générique.

**Attributs :**

* id
* name

---

### 👥 Client

Hérite de `Person`.

**Attributs supplémentaires :**

* customerNumber

---

### 💳 Account

Représente un compte bancaire générique.

**Attributs :**

* accountNumber
* balance
* client (propriétaire)

**Méthodes principales :**

* deposit(amount)
* withdraw(amount)
* getBalance()
* displayAccountInfo()

---

### 💰 SavingsAccount (Bonus)

Hérite de `Account`.

**Attributs supplémentaires :**

* interestRate

**Méthodes :**

* calculateInterest()

---

### 🏦 Bank

Classe centrale qui gère :

* La liste des clients
* La liste des comptes
* Les opérations bancaires
* Les validations métier

---

### ▶ Main

Interface console avec menu interactif :

1. Ajouter un client
2. Créer un compte
3. Afficher les comptes
4. Consulter un solde
5. Déposer
6. Retirer
7. Supprimer un compte
8. Transférer (Bonus)
9. Exporter vers Excel (Bonus)
10. Quitter

---

## ⚙️ Fonctionnalités principales

### 📌 Gestion des comptes

* Affichage de tous les comptes :

  * Numéro de compte
  * Nom du client
  * Type de compte
  * Solde

### 👤 Gestion des clients

* Ajout d’un client
* Association d’un ou plusieurs comptes

### 💵 Dépôt

* Vérification que le montant est positif

### 💸 Retrait

* Vérification que le solde est suffisant
* Vérification que le montant est valide

### 🗑️ Suppression de compte

* Suppression d’un compte existant

---

## ⭐ Fonctionnalités Bonus

### 🔄 Transfert d’argent

* Vérifie que :

  * Les deux comptes existent
  * Le montant est positif
  * Le solde du compte source est suffisant

---

### 📊 Compte épargne

* Création d’un `SavingsAccount`
* Calcul automatique des intérêts

---

### 📁 Export Excel (.xlsx)

Export de la liste des comptes avec :

* Numéro de compte
* Nom du client
* Type de compte
* Solde

Export déclenché depuis le menu console.

---

### 🛡️ Validation avancée

* ❌ Interdiction des montants négatifs ou nuls
* 🔒 Unicité des numéros de compte
* 🚫 Interdiction de supprimer un compte avec solde non nul

---

## 📁 Structure du projet (exemple)

```
src/
│
├── model/
│   ├── Person.java
│   ├── Client.java
│   ├── Account.java
│   ├── SavingsAccount.java
│
├── service/
│   └── Bank.java
│
└── Main.java
```

---

## 🚀 Lancement du projet

### 🔧 Prérequis

* Java 17 ou supérieur
* IDE recommandé : IntelliJ IDEA / Eclipse / VS Code

### ▶ Compilation

```bash
javac Main.java
```

### ▶ Exécution

```bash
java Main
```

---

## 🧪 Exemple de scénario

1. Ajouter un client
2. Créer un compte pour ce client
3. Effectuer un dépôt
4. Effectuer un retrait
5. Consulter le solde
6. Transférer vers un autre compte
7. Exporter les données

---

## 🛠️ Améliorations futures possibles

* Interface graphique (JavaFX / Swing)
* Base de données (MySQL / PostgreSQL)
* Authentification utilisateur
* Gestion des rôles (Admin / Client)
* API REST

---

## 📌 Statut du projet

Projet académique destiné à l’apprentissage de la Programmation Orientée Objet en Java.

---

## 👨‍💻 Auteur

Projet réalisé dans le cadre d’un apprentissage en développement Java.

---

Si tu veux, je peux aussi te faire :

* ✅ Une version plus professionnelle pour portfolio
* ✅ Une version en anglais
* ✅ Une version avec badges GitHub
* ✅ Un diagramme UML prêt à importer dans StarUML ou draw.io
* ✅ Un README plus “projet open-source sérieux” 🚀
