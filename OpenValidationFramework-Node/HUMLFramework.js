var HUMLFramework = function() {
    this.rules = [];

    this.CLEAN = function(){
        this.rules = [];
    }

    this.appendRule = function(name, fields, error, condition, disabled) {
            this.rules.push( {
                name : name,
                method : condition,
                error: error,
                fields:fields,
                disabled : disabled
        });
    }

    this.createVariable = function(name, clbk) {
        return {
            name : name,
            clbk : clbk,
            GetValue : function(model) {
                return this.clbk(model)
            }
        };
    }

    this.validate = function(model) {
        var errorSummary = {
            hasErrors:false,
            errors:[],
            fields:[]
        };

        var cntx = this;

        for(var x=0; x < this.rules.length; x++) {
            if(!this.rules[x].disabled){

                if (this.rules[x].method(model, cntx)) {
                    errorSummary.errors.push({
                        error: this.rules[x].error,
                        fields: this.rules[x].fields,
                    });

                    errorSummary.hasErrors = true;

                    if (this.rules[x].fields) {
                        this.rules[x].fields.forEach(f => {
                            if(!errorSummary.fields[f])
                                errorSummary.fields.push(f);
                        });
                    }

                }
            }
        }

        return errorSummary;
    }

    this.getEnabledRules = function() {
        var arRules = [];

        for(var x=0; x < this.rules.length; x++) {
            if (!this.rules[x].disabled && this.rules[x].error)
                arRules.push(this.rules[x]);
        }

        return arRules;
    }

    this.WHERE = function(arr, clbk) {
        var out = [];

        for(var x=0; x < arr.length; x++){
            if (clbk(arr[x])){
                out.push(arr[x]);
            }
        }

        return (out.length == 1)? out[0] : out;
    }

    this.ONE_OF = function(value, ...params){
        if(params.length == 1 && params[0].length > 0)
            return params[0].includes(value);
        return params.includes(value);
    }

    this.EQUALS = function(leftOperand, rightOperand)
    {
        return leftOperand == rightOperand;
    }

    this.NOT_EQUALS = function(leftOperand, rightOperand)
    {
        return !this.EQUALS(leftOperand, rightOperand);
    }

    this.LESS_THAN = function(leftOperand, rightOperand)
    {
        return leftOperand < rightOperand;
    }

    this.GREATER_THAN = function(leftOperand, rightOperand)
    {
        return leftOperand > rightOperand;
    }

    this.LESS_OR_EQUALS = function(leftOperand, rightOperand)
    {
        return leftOperand <= rightOperand;
    }

    this.GREATER_OR_EQUALS = function(leftOperand, rightOperand)
    {
        return leftOperand >= rightOperand;
    }

    this.AT_LEAST_ONE_OF = function(leftOperand, ...rightOperand)
    {
        if(rightOperand.length == 1 && rightOperand[0].length > 0)
            return rightOperand[0].includes(leftOperand);
        else
            return rightOperand.includes(leftOperand);
    }

    this.NONE_OF = function(leftOperand, rightOperand)
    {
        return !this.AT_LEAST_ONE_OF(leftOperand, rightOperand);
    }

    this.EMPTY = function(operand) {
        if (!operand) return true;

        if (Array.isArray(operand))
            return operand.length < 1;

        return false;
    }

    this.NOT_EMPTY = function(operand) {
        return !this.EMPTY(operand);
    }


    this.EXISTS = function(operand) {
        return !this.EMPTY(operand);
    }

    this.NOT_EXISTS = function(operand) {
        return this.EMPTY(operand);
    }

    this.SUM_OF = function(...operand){
        if(operand.length == 1 && operand[0].length > 0)
        {
            var value = 0;
            for (let i=0; i<operand[0].length; i++) {
                value += operand[0][i];
            }
            return value;
        } else {
            var value = 0;
            for (let i=0; i<operand.length; i++) {
                value += operand[i];
            }
            return value;
        }
    }

    this.sizeOf = function(operand){
        if(operand != null && operand.length)
                return operand.length;
        return 0;
    }

    this.atPosition = function(arr, pos){
        if(arr != null && arr.length && pos > 0 && pos <= arr.length)
                return arr[pos-1];
        return null;
    }

    this.FIRST = function(operand, amount){
        if(operand != null){
            if(!amount) amount = 1;
            if(operand.length && operand.length > amount){
                var out = [];
                for(var x=0; x < amount && x < operand.length; x++){
                    out.push(operand[x]);
                }
                return out.length == 1 ? out[0] : out;
            }
            return operand;
        }
        return null;
    }

    this.LAST = function(operand, amount){
        if(operand != null){
            if(!amount) amount = 1;
            if(operand.length && operand.length > amount){
                var out = [];
                var len = operand.length - amount;
                len = len < 0 ? 0 : len;
                for(var x=len; x < operand.length; x++){
                    out.push(operand[x]);
                }
                return out.length == 1 ? out[0] : out;
            }
            return operand;
        }
        return null;
    }

}


var humlFramework = new HUMLFramework();
module.exports = humlFramework;