import requests as rq

def postList(data_json, patch_rul , target):
    headers = {'content-type': 'application/json'}
    url = patch_rul.format(target)
    x = rq.post(url, data = data_json, headers = headers)
    return x