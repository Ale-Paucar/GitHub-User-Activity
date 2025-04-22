# GitHub User Activity Tracker
## https://roadmap.sh/projects/task-tracker
Este proyecto permite obtener y mostrar la actividad reciente de un usuario de GitHub, como los commits realizados, los pull requests y los comentarios en los issues. Actualmente, el proyecto solo maneja los siguientes tipos de eventos de GitHub:

- `PushEvent`
- `PullRequestEvent`
- `IssueCommentEvent`

## Requisitos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

- **Git**: [Descargar Git](https://git-scm.com/)
- **Java 17 o superior**: [Descargar Java](https://adoptopenjdk.net/)
- **Maven**: [Descargar Maven](https://maven.apache.org/)

## Instrucciones de uso

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/Ale-Paucar/GitHub-User-Activity.git
   cd GitHub-User-Activity
   ```
2. **Compilar el proyecto**:

Ejecuta el siguiente comando para limpiar el proyecto y construirlo:

   ```bash
    mvn clean install
   ```

3. **Ejecutar el proyecto**:

Después de la compilación, puedes ejecutar la aplicación con el siguiente comando:

   ```bash
    mvn exec:java
   ```

Esto pedirá el nombre de usuario de GitHub y mostrará la actividad reciente de ese usuario:

**Ejemplo de salida**:

```bash
  Please enter the github user name:
  kamranahmedse
- Pushed 2 commits to "kamranahmedse/developer-roadmap" on 22-Apr-2025
- PullRequestEvent in kamranahmedse/developer-roadmap on 22-Apr-2025
- IssueCommentEvent in asim/reminder on 20-Apr-2025
   ```
