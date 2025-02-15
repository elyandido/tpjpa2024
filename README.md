# 📌 JPA, Servlets, REST et OpenAPI Swagger - Base de Connaissances (FAQ)

## **Progression du Projet** 🚀

| **Module** | **Statut** |
|------------|-----------|
| JPA | ✅ Terminé |
| Servlets | ✅ Terminé |
| REST API (JAX-RS) | ✅ Terminé |
| OpenAPI & Swagger | ✅ Terminé |
| Vanilla JS | ⏳ À faire |
| Angular | ⏳ À faire |

---

## **1. Les Annotations Importantes en JPA**

### **1.1 Déclaration d'une Entité**
Une entité en JPA représente une table dans une base de données.
```java
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
}
```
📌 **Explication** :
- `@Entity` : Indique que la classe est une entité JPA.
- `@Table(name = "utilisateurs")` : Personnalise le nom de la table.
- `@Id` : Définit la clé primaire.
- `@GeneratedValue(strategy = GenerationType.IDENTITY)` : Auto-génère l'ID.

---

## **2. Correction des problèmes rencontrés**

### **Problème : Infinite Recursion (StackOverflowError)**
📌 **Solution : Éviter la boucle infinie dans les relations bidirectionnelles JPA avec Jackson**

Ajout de `@JsonIgnore` ou `@JsonBackReference` pour éviter la sérialisation récursive :
```java
@OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL)
@JsonIgnore // ✅ Empêche la récursion infinie
private List<Ticket> tickets;
```
Ou bien :
```java
@ManyToOne
@JoinColumn(name = "reference")
@JsonBackReference // ✅ Indique que cet attribut est une référence inverse
private Evenement evenement;
```

---
