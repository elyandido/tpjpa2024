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

2️⃣ Lancer le serveur REST avec RestServer

L'API REST utilise Undertow comme serveur d'application. Pour démarrer le serveur, exécutez :

mvn clean package
mvn exec:java -Dexec.mainClass="fr.istic.taa.jaxrs.RestServer"

Ou lancez la classe RestServer.java depuis votre IDE (IntelliJ, Eclipse) en exécutant la méthode main().

3️⃣ Vérifier que le serveur fonctionne

Une fois que le serveur est lancé, ouvrez un navigateur et testez l'URL suivante :

http://localhost:8080/ticket

Si tout fonctionne, cela devrait retourner une liste des tickets en JSON.

4️⃣ Tester l'API avec Postman

Action

Méthode

URL

Lister les tickets

GET

http://localhost:8080/ticket

Récupérer un ticket spécifique

GET

http://localhost:8080/ticket/1

Ajouter un ticket

POST

http://localhost:8080/ticket

Modifier un ticket

PUT

http://localhost:8080/ticket/1

Supprimer un ticket

DELETE

http://localhost:8080/ticket/1

📌 Si l'API retourne une erreur 404 Not Found, vérifiez :

Que RestServer est bien en cours d'exécution.

Que TicketResource est bien enregistrée dans TestApplication.

Que l'annotation @Path("/ticket") est bien présente dans TicketResource.

4. Lancer Swagger pour la documentation de l'API

Swagger permet de générer automatiquement une documentation interactive pour votre API REST.

1️⃣ Vérifier que Swagger est bien intégré

Assurez-vous que la classe RestApplication contient Swagger :

@OpenAPIDefinition(info = @Info(title = "API de gestion de tickets", version = "1.0"))
public class RestApplication extends Application {
}

2️⃣ Démarrer le serveur avec Swagger

mvn exec:java -Dexec.mainClass="fr.istic.taa.jaxrs.RestServer"

3️⃣ Accéder à l'interface Swagger

Ouvrez votre navigateur et accédez à :

http://localhost:8080/openapi.json

Ou pour la documentation interactive avec Swagger UI :

http://localhost:8080/swagger-ui/

📌 Swagger permet de tester directement l'API REST sans utiliser Postman.
