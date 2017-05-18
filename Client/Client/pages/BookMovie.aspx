<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="BookMovie.aspx.cs" Inherits="Client.BookMovie" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    
    <form id="form1" runat="server">
    <div>
    
    </div>
        <table>
            <tr>
                <td>
                    City :
                </td>
                <td>
        <asp:DropDownList ID="DropDownList4" runat="server" OnSelectedIndexChanged="DropDownList4_SelectedIndexChanged" AutoPostBack="True">
        </asp:DropDownList>
                            
                </td>
            </tr>
              <tr>
                <td>
                    Cinema :
                </td>
                <td>
        <asp:DropDownList ID="DropDownList3" runat="server" OnSelectedIndexChanged="DropDownList3_SelectedIndexChanged" AutoPostBack="True">
        </asp:DropDownList>
                            
                </td>
            </tr>
            <tr>
                <td>
                    <asp:Label ID="Label2" runat="server" Text="Movie"></asp:Label>
                </td>
                <td>
        <asp:DropDownList ID="DropDownList1" runat="server" OnSelectedIndexChanged="DropDownList1_SelectedIndexChanged" AutoPostBack="True">
        </asp:DropDownList>
                            
                </td>
            </tr>
            <tr>
                <td>
                    Category :
                </td>
                <td>
                    <asp:RadioButtonList ID="RadioButtonList2" runat="server" Height="16px" OnSelectedIndexChanged="RadioButtonList2_SelectedIndexChanged">
                        <asp:ListItem>Silver</asp:ListItem>
                        <asp:ListItem>Gold</asp:ListItem>
                        <asp:ListItem>Platinum</asp:ListItem>
        </asp:RadioButtonList>
                </td>
            </tr>
            <tr>
                <td>
                    Number of tickets :
                </td>
                <td>
                    <asp:DropDownList ID="DropDownList2" runat="server" OnSelectedIndexChanged="DropDownList2_SelectedIndexChanged" >
                        <asp:ListItem>1</asp:ListItem>
                        <asp:ListItem>2</asp:ListItem>
                        <asp:ListItem Value="3"></asp:ListItem>
                        <asp:ListItem>4</asp:ListItem>
                        <asp:ListItem>5</asp:ListItem>
        </asp:DropDownList>
        
                </td>
            </tr>
        </table>
        &nbsp;&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     
        
        <br />
        <br />
        <br />
        <br />
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Submit" />
        <br />
        <br />
        
        
        <asp:Table ID="info" runat="server">
            <asp:TableRow>
                <asp:TableCell>
                Name:</asp:TableCell>
                <asp:TableCell><asp:Label ID="name" runat="server"></asp:Label></asp:TableCell>
            </asp:TableRow>
            <asp:TableRow>
                <asp:TableCell>
                    Rating:
                </asp:TableCell>
                <asp:TableCell>
                    <asp:Label ID="rating" runat="server"></asp:Label>
                </asp:TableCell>
            </asp:TableRow>
            <asp:TableRow>
                <asp:TableCell>
                    Release Date:
                </asp:TableCell>
                <asp:TableCell>
                     <asp:Label ID="release" runat="server"></asp:Label>
                </asp:TableCell>
            </asp:TableRow>

        </asp:Table>
        <br />
        Amount :<asp:Label ID="Label4" runat="server" Text="0"></asp:Label>
        
        <br />
        <br />
        <br />
        <asp:Label ID="Label5" runat="server" Text="Label"></asp:Label>
        <br />
        <asp:Button ID="Button2" runat="server" OnClick="Pay_Click" Text="Pay" />
        <br />
        <br />
        <br />
        <br />
        <br />
    </form>
</body>
</html>
