
/**
 * @version Reversion: x.x, Date: 2013-3-26, Author: bridge;
 */

var Action = function(actionName)
{
	if (actionName == null || actionName == "")
	{
		alert("debug.error:999; parameters is null.");
		return;
	}
	this.actionName = actionName;
};

Action.prototype.list = function()
{
	var url = this.actionName + "!list.action";
	self.location = url;
};

Action.prototype.find = function(param)
{
	if (param == null || param == "")
	{
		alert("debug.error:999; parameters is null.");
		return;
	}

	var url = this.actionName + "!find.action&" + param;
	self.location = url;
};

Action.prototype.show = function(param)
{
	if (param == null || param == "")
	{
		alert("debug.error:999; parameters is null.");
		return;
	}

	var url = this.actionName + "!show.action&" + param;
	self.location = url;
};

Action.prototype.add = function()
{
	var url = this.actionName + "!add.action";
	self.location = url;
};

Action.prototype.edit = function(param)
{
	if (param == null || param == "")
	{
		alert("debug.error:999; parameters is null.");
		return;
	}
	
	var url = this.actionName + "!edit.action&" + param;
	self.location = url;
};

Action.prototype.del = function(param)
{
	if (param == null || param == "")
	{
		alert("debug.error:999; parameters is null.");
		return;
	}

	if (confirm("delete?"))
	{
		var url = this.actionName + "!delete.action&" + param;
		self.location = url;
	}
};


