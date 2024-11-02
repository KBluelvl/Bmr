# Bmr
The BMR project in JavaFX is a simple application designed to calculate the Basal Metabolic Rate (BMR).

This is a school project, and the project is written in French.

### Project Structure

The application follows the MVC (Model-View-Controller) architectural pattern:

- **Model**: Handles the data and logic for calculating BMR and adjusting for activity levels.

- **View**: Created with JavaFX, it provides an interactive and user-friendly graphical interface, allowing users to input their data and view results directly.

- **Controller**: Manages communication between the Model and the View, coordinating inputs and outputs.

### BMR Calculation

The calculation of **BMR (Basal Metabolic Rate)** is based on a different formula depending on the user's gender:

- For a **woman** :
`BMR = 9.6 * poids + 1.8 * taille - 4.7 * âge + 655`
 
- Pour un **homme** :
`BMR = 13.7 * poids + 5 * taille - 6.8 * âge + 66`

### Activity level

The application offers several activity levels, each with a coefficient that adjusts the base BMR to estimate daily caloric needs based on the level of physical activity:

| Niveau             | Coefficient | Description                            |
|--------------------|-------------|----------------------------------------|
| Sédentaire         | 1.2         | Peu ou pas d'activité physique         |
| Peu actif          | 1.375       | Activité physique légère               |
| Actif              | 1.55        | Activité physique modérée              |
| Fort actif         | 1.725       | Activité physique intense              |
| Extrêmement actif  | 1.9         | Activité physique très intense         |

# Preview
![image](https://github.com/user-attachments/assets/e18fbeff-dc60-45ad-83a1-1eae861b5832)
![image](https://github.com/user-attachments/assets/85b368f8-d033-4fbd-9437-6b833bbebbed)
