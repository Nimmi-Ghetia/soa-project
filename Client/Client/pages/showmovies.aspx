<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="showmovies.aspx.cs" Inherits="Client.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    
</head>
<body>
    <asp:HyperLink NavigateUrl="~/pages/BookMovie.aspx" runat="server">Book movie</asp:HyperLink>
    <form id="form1" runat="server">
    <div>
    <asp:Button runat="server" Text="Show movies" OnClick="Button1_Click" />
    </div>
       
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="false">
       <Columns>
           

           <asp:TemplateField>
           <ItemTemplate>
               <%#Eval ("Name") %>
           </ItemTemplate>    
           </asp:TemplateField>
           
       </Columns>     
       </asp:GridView>
       
    </form>
</body>
</html>
