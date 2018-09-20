'use strict';

function WebDavViewer(web_dav_server) {
    var web_dav_viewer = {};

    var client = webdav(web_dav_server);

    web_dav_viewer.view = function(dom_parent, folder){
        var div =  document.getElementById(dom_parent.slice(1));

        var table = document.createElement('table');
        table.classList.add("table");
        table.classList.add("table-striped");
        table.classList.add("table-light");
        var tbody = document.createElement('tbody');
        table.appendChild(tbody);

        client.getDirectoryContents("/").then(function(contents) {

            var rowIndex = 0;
            contents.forEach(function(element){
                var row = table.insertRow(rowIndex);
                var cell = row.insertCell(0);
                var a = document.createElement('a');
                a.appendChild(document.createTextNode(element.basename));
                a.title = element.basename;
                a.href = element.filename;
                cell.appendChild(a);
                tbody.appendChild(row);
                console.log(element.basename);

                rowIndex += 1;
            })
        });

        div.appendChild(table);

        return web_dav_viewer;
    };

    return web_dav_viewer;
}