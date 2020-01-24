# OpenValidation HUMLFramework Node Test Project

## Replace HUMLFramework Code File

Replace `HUMLFramework.js`.

## Build and Test

run

```npm
npm test
```

## Build with

install dev dependencies, (optinal) insall jamin globally for easier execution

```bash
npm install

node node_modules/jasmine/bin/jasmine.js
```

optional: install jamin globally and execute directly

```bash
npm install -g jasmin

jasmine
```

## Notes

### Validators

In Node, the validators are currently exported as singletons.
In the past, this has posed some problems for testing validators in the jasmin testrig and we are currently working on a solution for this behaviour (this entails either the re-write of the validator generation code, or the change of the testign routine for validators, a decision is still being made)

## Additional Reference material

- [How to test with Jasmin and Karma](https://codecraft.tv/courses/angular/unit-testing/jasmine-and-karma/)