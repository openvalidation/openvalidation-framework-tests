import HUMLFramework as huml

class HUMLValidator(huml.HUMLFramework):
    def __init__(self):
        super().__init__()



        self.append_rule(
            "",
            ["number"],
            "number must be greater than 5",
            lambda model, cntx: huml.LESS_OR_EQUALS(model.number, 5.0),
            False
        )

