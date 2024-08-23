     ##  Courses App
This Android application is a simple app that displays a list of course topics using Jetpack Compose. The app presents a grid view of various topics with their images and information.

Structure
1. MainActivity
The main activity is the entry point of the app and contains the CoursesApp composable.

2. CoursesApp
Displays the list of courses. It uses the CoursesList composable to  show the topics in a grid.

3. CoursesList
Shows the courses in a 2-column grid using LazyVerticalGrid.

4. CoursesCard
Displays each course in a card. The card includes the title, model version, and an image.

5. DataSource
Provides the data source for courses. It includes a list of Topic objects with course titles, model versions, and images.

6. Topic
A data class representing course topics. It includes the title, model version, and image resources.
