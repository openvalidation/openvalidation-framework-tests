# Framework Testing - Template

List of all methods of the HUMLFramework that need to be tested:

## Framework methods

- [ ] appendRule
- [ ] validate
- [ ] validateRule
- [ ] executeRuleCondition
- [ ] createVariable

## Comparison methods

- [ ] EQUALS
- [ ] NOT_EQUALS
- [ ] EMPTY
- [ ] NOT_EMPTY
- [ ] LESS_THAN
- [ ] LESS_OR_EQUAL
- [ ] GREATER_THAN
- [ ] GREATER_OR_EQUAL

## Array/List methods

- [ ] ONE_OF
- [ ] NONE_OF
- [ ] AT_LEAST_ONE_OF
- [ ] SUM_OF
- [ ] getArrayOf
- [ ] where
- [ ] sizeOf
- [ ] atPosition
- [ ] FIRST
- [ ] LAST

## Language specific methods

Specialized functions used in the language version of the framework.
i.e. java uses multiple functions for converting between lists and arrays.

## Unused in this language

in this section, some operations can be listed when deriving a Framework from another.
i.e. the CSharp framework is based on the Java implementation. But all of the array/list casting methods remain unused in Csharp, as all complex collections are of type IEnumerable and do not need to be explicitly cast into another format.
