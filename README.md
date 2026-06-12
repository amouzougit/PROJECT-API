# PROJECT-API (OffreAPI)

Une API REST robuste et sécurisée pour la gestion des offres, développée avec **Spring Boot** et **MongoDB**.

## 📋 Description

**OffreAPI** est une application API REST complète qui fournit des fonctionnalités de gestion d'offres avec authentification sécurisée basée sur JWT, validation des données, stockage MongoDB et intégration email.

## 🚀 Fonctionnalités Principales

- ✅ **API REST** - Endpoints RESTful bien structurés
- 🔐 **Authentification & Sécurité** - JWT tokens pour la sécurisation des endpoints
- 🗄️ **Base de Données MongoDB** - NoSQL pour la flexibilité et la scalabilité
- 📧 **Notification par Email** - Système d'envoi d'emails intégré
- 📚 **Documentation Swagger/OpenAPI** - Documentation interactive de l'API
- ✔️ **Validation des Données** - Validation robuste des entrées
- 🧪 **Tests Unitaires** - Couverture de tests avec Spring Security Test

## 🛠️ Stack Technologique

| Technologie | Version | Utilisation |
|---|---|---|
| **Java** | 1.8+ | Langage principal |
| **Spring Boot** | 2.6.0 | Framework web |
| **Spring Security** | - | Authentification & Autorisation |
| **MongoDB** | - | Base de données NoSQL |
| **JWT (JJWT)** | 0.9.1 | Tokens d'authentification |
| **Spring Mail** | - | Système d'emails |
| **SpringDoc OpenAPI** | 1.6.9 | Documentation Swagger |
| **Maven** | - | Gestion des dépendances |

## 📦 Prérequis

- **Java 8** ou supérieur
- **Maven 3.6+**
- **MongoDB** (local ou cloud)
- Un serveur SMTP pour l'envoi d'emails (optionnel)

## ⚡ Installation & Démarrage

### 1. Cloner le repository

```bash
git clone https://github.com/amouzougit/PROJECT-API.git
cd PROJECT-API
```

### 2. Configurer l'environnement

Créez un fichier `application.properties` ou `application.yml` dans `src/main/resources/` :

```properties
# MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/offreapi
spring.data.mongodb.database=offreapi

# Server
server.port=8080
server.servlet.context-path=/api

# JWT
jwt.secret=votre_secret_jwt_ici
jwt.expiration=86400000

# Mail (optionnel)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=votre_email@gmail.com
spring.mail.password=votre_mot_de_passe
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### 3. Compiler et lancer l'application

**Avec Maven (Linux/Mac) :**
```bash
./mvnw spring-boot:run
```

**Avec Maven (Windows) :**
```bash
mvnw.cmd spring-boot:run
```

**Ou avec Maven traditionnel :**
```bash
mvn clean install
mvn spring-boot:run
```

L'application démarre sur `http://localhost:8080/api`

## 📖 Documentation de l'API

Une fois l'application lancée, accédez à la documentation Swagger :

```
http://localhost:8080/api/swagger-ui.html
```

ou

```
http://localhost:8080/api/v3/api-docs
```

## 🏗️ Structure du Projet

```
PROJECT-API/
├── src/
│   ├── main/
│   │   ├── java/com/offreapi/
│   │   │   ├── controller/          # Contrôleurs REST
│   │   │   ├── service/             # Logique métier
│   │   │   ├── repository/          # Accès aux données MongoDB
│   │   │   ├── model/               # Entités et DTOs
│   │   │   ├── security/            # Configuration JWT & Security
│   │   │   └── config/              # Configurations globales
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-prod.properties
│   └── test/
│       └── java/com/offreapi/       # Tests unitaires
├── .mvn/                            # Maven Wrapper
├── pom.xml                          # Dépendances Maven
├── mvnw & mvnw.cmd                  # Scripts d'exécution Maven
├── .gitignore
└── README.md
```

## 🔐 Authentification JWT

### Flux d'authentification

1. **Login** - Envoyez vos identifiants à `/auth/login`
2. **Token JWT** - Recevez un token valide pendant 24h
3. **Utilisation** - Incluez le token dans le header `Authorization: Bearer <token>`

**Exemple de requête sécurisée :**
```bash
curl -H "Authorization: Bearer votre_jwt_token" \
     http://localhost:8080/api/offres
```

## 📧 Système d'Emails

L'API supporte l'envoi d'emails pour les notifications :

- Configuration SMTP requise
- Envoi asynchrone recommandé
- Templates email personnalisables

## 🧪 Tests

Exécuter les tests :

```bash
mvn test
```

Tests avec couverture :
```bash
mvn test jacoco:report
```

## 🐛 Dépannage

### MongoDB non accessible
```
Error: No suitable servers found
```
**Solution** : Vérifiez que MongoDB est lancé et accessible via l'URI configurée.

### Erreur JWT - Token invalide
```
Error: JWT validation failed
```
**Solution** : Vérifiez que le `jwt.secret` est identique partout et le token n'a pas expiré.

### Email non envoyé
```
Error: javax.mail.AuthenticationFailedException
```
**Solution** : Vérifiez les identifiants SMTP et que le compte autorise les connexions "Applis moins sécurisées" (Gmail).

## 🤝 Contribution

Les contributions sont les bienvenues ! N'hésitez pas à :

1. Fork le projet
2. Créer une branche (`git checkout -b feature/AmazingFeature`)
3. Commit vos changements (`git commit -m 'Add AmazingFeature'`)
4. Push vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrir une Pull Request

## 📝 License

Ce projet est sous license MIT. Voir le fichier `LICENSE` pour plus de détails.

## 👨‍💻 Auteur

**amouzougit** - [GitHub Profile](https://github.com/amouzougit)

## 📞 Support & Questions

Pour toute question ou problème :
- 📧 Ouvrez une issue sur GitHub
- 💬 Consultez la documentation Swagger de l'API

---

**Dernière mise à jour** : Juin 2026
**Statut** : En développement actif ✨
