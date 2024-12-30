# **Gestion_Jeu**

## **Description**
Gestion_Jeu est une application console permettant de gérer un parc de jeux vidéo. Elle propose des fonctionnalités pour gérer :  
- Les jeux vidéo disponibles.  
- Les clients enregistrés.  
- Les emprunts effectués par les clients.  

## **Fonctionnalités**
- Affichage, ajout, modification et suppression des jeux vidéo.  
- Gestion des clients : ajout, modification, suppression, et affichage.  
- Gestion des emprunts : enregistrement d’un emprunt et restitution des jeux loués.  

## **Structure du projet**

### **1. Classe `Main`**  
- Point d’entrée de l’application.  
- Appelle la classe `Application` pour démarrer le programme.  

### **2. Classe `Application`**  
- Classe principale de gestion.  
- **Singleton** : une seule instance de cette classe peut être créée.  
- Gère :  
  - Le menu principal et les choix de l’utilisateur.  
  - La génération des identifiants pour les clients et les jeux.  
  - La gestion des emprunts.  

### **3. Classe `Display`**  
- Responsable des affichages côté console.  
- Fournit des méthodes pour le CRUD (Create, Read, Update, Delete) des jeux et des clients.  

### **4. Modèles (données)**  
Les modèles représentent les entités principales de l’application :  
- **`Client`** :  
  - Attributs : `nom`, `prénom`, `âge`, `id`, `date de naissance`.  
- **`JeuxVideo`** :  
  - Attributs : `nom`, `développeur`, `date de sortie`, `genre`, `classification PEGI`, `id`, `disponibilité` (boolean).  
- **`Emprunt`** :  
  - Attributs :  
    - `loueur` (de type `Client`).  
    - `jeuLoué` (de type `JeuxVideo`).  

Tous les modèles incluent des :  
- Constructeurs.  
- Getter et setter.  
- Attributs privés pour assurer l'encapsulation.

### **5. Gestionnaires**  
Trois classes dédiées gèrent les données et assurent une seule instance grâce à leur implémentation en singleton :  
- **`GestionJeu`** : Gère le parc de jeux vidéo avec une `ArrayList`.  
- **`GestionClient`** : Gère les clients avec une `ArrayList`.  
- **`GestionEmprunt`** : Gère les emprunts réalisés par les clients avec une `ArrayList`.  

---

## **Particularités**
- Le projet n'utilise pas de base de données. Les données sont uniquement manipulées en mémoire.  
- **Initialisation des données** : Un jeu d’essai peut être généré grâce à une fonction `init`, que l’utilisateur doit appeler via le menu principal. Cette fonction n’est pas exécutée automatiquement.  

