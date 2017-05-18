<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="pay.aspx.cs" Inherits="Client.pages.pay" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
        <script type="text/javascript">
            function printData() {
            var divToPrint= document.getElementById("print");
                var bh=document.getElementById("id") ;

                
        var htmlToPrint="<center>Your ticket id is"+bh.outerHTML+"</center><br>"  ;
        htmlToPrint += '' +
                    '<style type="text/css">' +
        'table, table th, table td {' +
                  'border: 1px solid black;'+
                 'border-collapse: collapse;'+      
                 'font-family:areial;'+
                 'text-align: left;'+
                 'font-size:100%;'+
                 'height: 10px;'+
                 'line-height: 120%;'+
                 'padding: 5px;'+
        '}' +
        '</style>';
    htmlToPrint += divToPrint.outerHTML;
                newWin= window.open("");
                newWin.document.write(htmlToPrint);
                newWin.print();
                newWin.close();
            
    }
    </script>
            
             
    
    
    <title></title>
</head>

<body>
    <form id="form1" runat="server">
    <div>
        Your Ticket id is <asp:Label runat="server" ID="id"></asp:Label>

        <br />

     
        <asp:Button ID="Button2" runat="server" CssClass="abc" Text="Get Pdf" OnClick="Submit_Click"/>    
    </div>
           <div id="print" runat="server">

           </div>

        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
    </form>
</body>
    
</html>
