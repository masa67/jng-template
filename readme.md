
# Introduction

This is a simple demo on implementing a RESTful service with Java Spring and AngularJS.

The demo takes the [mean-template](https://github.com/masa67/mean-template) and replaces Node and Express with Spring. The used database is still MongoDB.

The demo is built in the spirit of [Spring Guides](http://spring.io/guides) and [Spring Boot](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/):

* The application can be "just run", i.e., additional environments (like Tomcat) are not required, except MongoDB.
* The configuration is based on Auto-Configuration and annotations (no `web.xml`).

For MongoDB, the used database is "mean-template-3", collection "userlist". This is inline with [mean-template](https://github.com/masa67/mean-template), so the environments cam be run against the same database/collection.

A couple of changes were required to the Angular part:

* The logic how Spring handles MongoDB `_id` was not clear. Spring sends `id` instead of `_id`, and there was no success in trying to change that behaviour.
* `params` were added to `deleteUser` (`Users.js`). Not clear why the original example is functional without this.

# Installation

Install [MongoDB](https://www.mongodb.org). Start the daemon.

Use Maven to build the Java application.

# Execution

Start the application and go to [http://localhost:8080](/http://localhost:8080/).
