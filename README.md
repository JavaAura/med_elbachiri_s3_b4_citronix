# Citronix Farm Management API

Welcome to **Citronix**, an API designed to streamline farm management for lemon producers. This application helps farmers track farms, fields, trees, harvests, and sales, ensuring optimized productivity and seamless operations.

---

## Features at a Glance

### 🌾 **Farm Management**
- Create, update, and view farm details (name, location, area, and creation date).
- Advanced search using multiple criteria.

### 🌱 **Field Management**
- Associate fields with farms and define their area.
- Automatic validation of field areas:
  - Total field area must be less than farm area.
  - Max 10 fields per farm.

### 🌳 **Tree Management**
- Monitor tree lifecycle:
  - Planting date, age, and associated field.
- Annual productivity:
  - Young (<3 years): 2.5 kg/season.
  - Mature (3-10 years): 12 kg/season.
  - Old (>10 years): 20 kg/season.

### 🌦 **Harvest Management**
- Track seasonal harvests (winter, spring, summer, autumn).
- Log total quantity and date per season.

### 📊 **Sales Management**
- Record sales with client details, unit price, and associated harvest.
- Auto-calculate revenue: `Revenue = quantity * unit price`.

---

## Getting Started

### Prerequisites
Ensure the following are installed on your machine:
- **Java 8** or later
- **Maven**
- **Postman** or **Swagger** (optional for API testing)

### Running the Application
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd Citronix
2. Build and run the application:
    ```bash
    mvn spring-boot:run
3. Access the API:
    - API documentation: ```http://localhost:8080/swagger-ui```

## Database Setup
- Development: Embedded H2 database (preconfigured).
- Production: Switch to PostgreSQL (update ```application.properties```).


## Example Usage
### Farm Creation
    ```bash
    POST /farms
    {
      "name": "Sunny Lemon Farm",
      "location": "California",
      "area": 50,
      "creationDate": "2020-05-15"
    }
### Productivity Calculation
1. Add a tree:
    ```bash
    POST /trees
    {
      "plantingDate": "2018-03-10",
      "fieldId": 1
    }
2. View tree productivity: 
    ```bash
    GET /trees/1/productivity
--
## Contact
    For any queries or support, please contact:
    support@citronix.com
    +1-800-CITRON
- --
<sup>Created by **Bachiriy**</sup>
