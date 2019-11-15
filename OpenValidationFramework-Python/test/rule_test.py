import HUMLFramework as huml 

class TestRulesAppendRule:

    def test_appending_a_rule(self):
        validator = huml.HUMLFramework()
        validator.append_rule(
            name="",
            fields=["name"],
            error="name must be something",
            condition_function=lambda input, cntx: huml.NOT_EQUALS(input, "something"),
            disabled=False
        )
        assert len(validator.rules) >= 1

    def test_appending_10_rules(self):
        validator = huml.HUMLFramework()
        for _ in range(10):
            validator.append_rule(
                "",
                ["name"],
                "name must be something",
                lambda input, cntx: huml.NOT_EQUALS(input, "something"),
                False
            )
        assert len(validator.rules) >= 10

class TestRulesValidate:

    def test_none_not_equals_something(self):
        validator = huml.HUMLFramework()
        validator.append_rule(
            "",
            ["name"],
            "name must be something",
            lambda input, cntx: huml.NOT_EQUALS(input, "something"),
            False
        )
        assert validator.validate(None)["has_errors"]
