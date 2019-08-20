# Developer Survey Breakdown
A full stack web application that allows users to breakdown the Stack Overflow Developer Survey. Uses Spring Boot as a REST API and React as the front-end that calls the API and generates views based off responses.

## Features
- **REST API:** Spring Boot REST API that returns JSON data about the Stack Overflow Developer Survey. The controller accepts HTTP parameters to filter the data.
- **React Single Page View:** Single page React front-end that calls the REST API based off user actions. Displays relevant data in the form of graphs. Users can change query parameters with option dropdowns. Allows for multiple graphs to be manipulated and compared at a time.
- **Dynamic View:** The front-end is styled with [Bootstrap](https://getbootstrap.com/) for a responsive mobile-friendly layout.

## Set Up
1. Download this repository 
2. Download the CSV that data is loaded from [here](https://www.kaggle.com/stackoverflow/stack-overflow-2018-developer-survey#survey_results_public.csv)
3. In the Spring project set CSV_URL inside Bootstrap.java to the path of your CSV
4. Install all dependencies (use npm install for React)
5. Run both the Spring project and the React project (use npm start for React)
6. Visit http://localhost:3000/

## Demo Video
[![Demo Video](https://img.youtube.com/vi/MeAujgK-QNs/hqdefault.jpg)](https://www.youtube.com/watch?v=MeAujgK-QNs)
