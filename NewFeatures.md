# Add Features to HUMLFramework

When considering to add a new feature to HUMLFramework, we encourage you towards the following process:

1. Create an issue on [openValidation](https://github.com/openvalidation/openvalidation/issues), describing in detail what feature you are planning to implement, and what problem you are trying to fix by implementing that feature.
2. Make a fork of this repository, and implement the Function in a HUMLFramework in any language.
3. Write tests for your function. Does it behave in the way you expect it to?
    - Optional: We encourage you to implement and write tests in as many languages on this repository as you can.
4. Make sure to add your function to all [FrameworkTesting](FrameworkTesting.md)-files for all languages in this repository. Cross off any, that you have implemented and tested.
5. Create a fork of [openValidation](https://github.com/openvalidation/openvalidation).
6. Add your new function to the generation template for the HUMLFramework of your target language.
7. Generate the framework-file locally. And run all tests (`mvn clean test -Pintegration`). If you break any of the unit tests, or the project fails to compile, you have likely broken something in code generation by inserting your function in a wrong way.
8. If everything compiles and all tests are green, create a pull request for your feature on this respository for the tests of your new function.
9. Create a pull request on [openValidation](https://github.com/openvalidation/openvalidation/pulls), linking to the pull request on this repository.
