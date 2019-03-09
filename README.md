# northwindsTest
The MS Access Northwinds application migrated to a CUBA application, with some enhancements to access the Tomtom maps service 
and the Marvel API.

Intro
=====
The majority of this code was converted automatically using a proprietary tool created by Transformix to migrate MS Access 
applications to CUBA applications. 

If you would like Transformix to give you an estimate for migrating your MS Access application to the CUBA platform please email sales@xformix.com.

Running
=======
First step is to create and restore the northwindstest Postgresql database, using the northwindstest.backup file.

After that, you should obtain keys from the Tomtom and Marvel sites (see below) used by the enhancements to the Cusomers (Tomtom) 
and Employees (Marvel) forms.

Then, just start up the application and you should be good to go.

Enhancements (things added after the initial automated migration)
============

The Customers form contains a Tomtom map.
The Employees form contains a "super hero" label and image pulled from the Marvel API

IMPORTANT - replacing API keys
==============================
>>> You should obtain your own developer key from the Tomtom site https://developer.tomtom.com/
>>> and replace the "tomtom.key" property specified in modules/web/web/WEB-INF/local.app.properties
>>>
>>> You should obtain your own developer key (valid for both map and search apis) from https://developer.marvel.com/
>>> and replace the "marvelapi.publicKey" and "marvelapi.privateKey" properties specified in 
>>> modules/core/src/com/xformix/northwindstest/app.properties
 
