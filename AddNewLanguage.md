# Add a new language translation for HUMLFramework

If you want to add any language you should check the following steps:

1. Create a new Folder to house the testing project in the root of this repository. Naming it according to convention `OpenValidationFramework-Language`.
2. Make a Copy of `FrameworkTesting.md` inside the language folder. This File serves as a Checklist, as to what functions are currently tested for in the test project.
3. The general idea for these Testing Frameworks is to provide test coverage for generated `HUMLFramework`-files. The `HUMLFramework`-file can not depend on any other code, and all Tests should just access the public members of this file/class.
4. Add a `Readme.md` File for your language that gives the following information:
    1. How to update the Framework to be tested (`HUMLFramework`-file location). If any special parameters where used in generating this version of the `HUMLFramework`-file, add a note in this section on how to generate the correct version.
    2. How to build and run the tests. Add notes as to any dependencies and how to install them.
    3. Feel free to link to the docs of the Testing Framework used. You might not be the one adding tests for new Features of `HUMLFramework` in your language.
5. Add a link to your Readme in the global [Readme](Readme.md) of this repository.
