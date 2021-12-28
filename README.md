# mudiAdvertisingProject_SpringMVC
# Project developed during the course (Spring MVC: create a web app using Thymeleaf and Bootstrap).

## The project was developed to learn and put into practice: 

* MVC pattern with Spring MVC
* Use Spring Data for persistence
* Create better views with Thymeleaf
* Validate data with BeanValidation
* Resolve dependencies with dependency injection
* Use Spring Security to create a login
* Style HTML with Bootstrap

## About The Project
Create a Java web application for two types of users (clients and sellers).
<p>
 * A client that would like to buy a specific product and a seller that would like to sell that product for the client that registered it in the application.
</p>

<p>
 * The project was created using Spring MVC and Spring data for persistence.
</p>

<p>
 * The database used was the MariaDB.
 Currently, in the database there is one entity called 
 "pedido" with the following fields:(id | data_da_entrega | descricao | nome_produto | url_da_imagem | url_do_produto | valor_negociado | status).
</p>

<p>
 * For the view section was used: Thymeleaf and Bootstrap.
</p>


&nbsp;&nbsp;
# The second part of this project (part-2 branch) was created during the course (Spring MVC: Authentication with Spring Security, Rest API and AJAX).

## The project was developed to learn and put into practice:

* Create a login system with Spring Security
* Learn how to execute AJAX requests with Axios
* Build a SPA-style canvas with Vue.js
* Monitor application with interceptors
* Define a REST API with RestControllers
* Learn how to use paging and caching


 ## About The second part of the Project
 Main modifications:

 * Implementation of login and logout.
 * Usage of paging and sorting.
 * Usage of REST concept to build an API returning JSON.
 * Build an HTML page with Vue.js
 * Executing AJAX requests with Axios


 <p> The database (MariaDB):</p>
 Currently, in the database was added the following  entities:

 * "authorities" with the following fields:(username | authority)
 * "offer" with the following fields:(id | comentario | data_da_entrega | valor | pedido_id)
 * "users" with the following fields:(username | password | enabled)

<img src="https://user-images.githubusercontent.com/61911750/147610586-2b52849e-d804-4e0c-be0d-b59c78068f94.png" width="450" height="450" />
